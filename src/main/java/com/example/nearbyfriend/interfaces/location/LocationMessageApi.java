package com.example.nearbyfriend.interfaces.location;

import com.example.nearbyfriend.application.location.LocationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class LocationMessageApi {
    private final LocationFacade locationFacade;

    /**
     * 주기적인 위치 갱신
     * @param alarmLocation
     */
    @MessageMapping("/location")
    public void subscribeFriend(LocationMessageDto.AlarmLocation alarmLocation) {

    }
}
