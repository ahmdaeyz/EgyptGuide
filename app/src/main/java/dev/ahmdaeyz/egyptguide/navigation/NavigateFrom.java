package dev.ahmdaeyz.egyptguide.navigation;

import dev.ahmdaeyz.egyptguide.data.entities.GuideLocation;

public interface NavigateFrom {
    interface Location{
        void toGuide();
    }
    interface Guide{
        void toLocation(GuideLocation location);
    }

}
