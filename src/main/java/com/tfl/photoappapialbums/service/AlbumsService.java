package com.tfl.photoappapialbums.service;

import com.tfl.photoappapialbums.data.AlbumEntity;

import java.util.List;

public interface AlbumsService {
    List<AlbumEntity> getAlbums(String userId);
}
