package manjaro.mpb.component

import manjaro.mpb.ui.Icons
import javax.swing.ImageIcon

enum class MBCharacter(val icon: ImageIcon) {

    MARIO(Icons.MARIO),
    LUIGI(Icons.LUIGI);

    val displayName: String = icon.description

}