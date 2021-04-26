package br.com.objective.view;

import javax.swing.*;

public class DialogoView {
    private static final String NOME_JOGO = "Jogo Gourmet";

    public int mostrarTelaInicial() {
        return JOptionPane.showConfirmDialog(null, "Pense em um prato que você gosta.", NOME_JOGO,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    public int abrirDialogoConfirmacao(final String prato) {
        String mensagem = "O prato que você pensou é " + prato + "?";
        return JOptionPane.showConfirmDialog(null, mensagem, "Confirm", JOptionPane.YES_NO_OPTION);
    }

    public void mostrarMensagemSucesso() {
        JOptionPane.showMessageDialog(null, "Acertei de novo.");
    }

    public String mostrarCaixaTexto(String mensagem, String titulo) {
        return JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
    }
}
