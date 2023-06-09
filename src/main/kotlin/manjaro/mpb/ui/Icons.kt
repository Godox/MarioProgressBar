package manjaro.mpb.ui

import javax.swing.ImageIcon

interface Icons {
    companion object {
        val MARIO = ImageIcon(Icons::class.java.getResource("/mario.gif"), "Mario")
        val LUIGI = ImageIcon(Icons::class.java.getResource("/luigi.gif"), "Luigi")

        val SHELL = ImageIcon(Icons::class.java.getResource("/shell.gif"), "Green shell")

    }
}
