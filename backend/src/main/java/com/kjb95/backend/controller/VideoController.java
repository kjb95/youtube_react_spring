package com.kjb95.backend.controller;

import com.kjb95.backend.entity.Video;
import com.kjb95.backend.service.VideoService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    @PostMapping("/api/playlist/initial-value")
    public void playlistInitialValue(@RequestBody Map<String,Object>[] playlist) {
        Arrays.stream(playlist).forEach(videoService::addPlaylist);
    }

    @GetMapping("/api/playlist")
    public List<Video> getPlaylist() {
        return this.videoService.getPlaylist();
    }

    @PostMapping("/api/playlist")
    public void addPlaylist(@RequestBody Map<String,Object> playlist) {
        videoService.addPlaylist(playlist);
    }
}