package org.cates

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonController)
class CatesController {
    CatesModel model

    void click() {
        model.clickCount++
    }
}