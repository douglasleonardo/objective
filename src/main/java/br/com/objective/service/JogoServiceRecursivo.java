package br.com.objective.service;

import br.com.objective.model.Prato;
import br.com.objective.view.DialogoView;

import javax.swing.*;

public class JogoServiceRecursivo {
    private Prato pratoInicial;
    private DialogoView dialogoView = new DialogoView();
    private boolean fecharJogo = false;

    public JogoServiceRecursivo() {
        pratoInicial = new Prato("Massa");
        pratoInicial.setPratoRelacionado(new Prato("Lasanha"));
        pratoInicial.setPratoCorreto(new Prato("Bolo de chocolate"));
    }

    public void iniciarJogo() {
        if (fecharJogo)
            return;

        int continuarJogando = dialogoView.mostrarTelaInicial();
        if (continuarJogando == JOptionPane.OK_OPTION)
            escolherCaracteristicaPrato();

        System.out.println("Fim de jogo!");
    }

    private void escolherCaracteristicaPrato() {
        int resultado = dialogoView.abrirDialogoConfirmacao(pratoInicial.getCaracteristica());
        fecharJogo = resultado == JOptionPane.CLOSED_OPTION;
        if (fecharJogo)
            return;

        if (resultado == JOptionPane.YES_OPTION) {
            adivinharPrato(pratoInicial.getPratoRelacionado());
        } else {
            adivinharPrato(pratoInicial.getPratoCorreto());
        }

        iniciarJogo();
    }

    private void adivinharPrato(Prato prato) {

        int resultado = dialogoView.abrirDialogoConfirmacao(prato.getCaracteristica());
        fecharJogo = resultado == JOptionPane.CLOSED_OPTION;
        if (fecharJogo)
            return;

        if (resultado == JOptionPane.YES_OPTION && prato.isFimArvorePratos()) {
            dialogoView.mostrarMensagemSucesso();
            iniciarJogo();
        } else {
            if (resultado == JOptionPane.YES_OPTION && prato.isPratoCorreto()) {
                adivinharPrato(prato.getPratoCorreto());
            } else if (resultado == JOptionPane.NO_OPTION && prato.isTemPratoRelacionado()) {
                adivinharPrato(prato.getPratoRelacionado());
            } else {
                String dishName = dialogoView.mostrarCaixaTexto("Qual prato vocẽ pensou?", "Desisto");
                fecharJogo = dishName == null;
                if (fecharJogo)
                    return;

                String message = String.format("%s é _____ mas %s não.", dishName, prato.getCaracteristica());
                String attribute = dialogoView.mostrarCaixaTexto(message, "Complete.");
                fecharJogo = attribute == null;
                if (fecharJogo)
                    return;

                adicionarPrato(prato, attribute, dishName);
            }
        }

    }

    private void adicionarPrato(Prato prato, String caracteristica, String nomePrato) {
        String valorAntigo = prato.getCaracteristica();
        prato.setPratoRelacionado(new Prato(valorAntigo));
        prato.setPratoCorreto(new Prato(nomePrato));
        prato.setCaracteristica(caracteristica);
    }
}
