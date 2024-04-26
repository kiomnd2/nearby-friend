package com.example.nearbyfriend.domain.member;

import com.example.nearbyfriend.domain.location.Location;
import com.example.nearbyfriend.domain.location.LocationCommand;
import com.example.nearbyfriend.domain.location.LocationRedisPublisher;
import com.example.nearbyfriend.infrastructure.location.LocationRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberAlarmHelper {
    private final MemberReader memberReader;
    private final LocationRedisRepository locationRedisRepository;
    private final LocationRedisPublisher locationRedisPublisher;

    public void alarmLocationAllActiveFriend(Location location) {
        List<String> friendsList = memberReader.readMemberFriends(location.getUserId());
        for (String friend : friendsList) {
            // 실제 캐시에 있는 친구들만 알람
            if (locationRedisRepository.getLocation(friend) != null) {
                locationRedisPublisher.publish(friend, location.toRedisStoreCommand());
            }
        }
    }

}
