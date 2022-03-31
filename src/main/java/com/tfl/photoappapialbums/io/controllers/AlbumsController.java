package com.tfl.photoappapialbums.io.controllers;

import com.tfl.photoappapialbums.data.AlbumEntity;
import com.tfl.photoappapialbums.service.AlbumsService;
import com.tfl.photoappapialbums.ui.model.AlbumResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users/{id}/albums")
public class AlbumsController {

    private final AlbumsService albumsService;

    public AlbumsController(AlbumsService albumsService) {
        this.albumsService = albumsService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<AlbumResponseModel> userAlbums(@PathVariable String id) {
        List<AlbumResponseModel> returnValue = new ArrayList<>();
        List<AlbumEntity> albumEntities = albumsService.getAlbums(id);
        if (albumEntities == null || albumEntities.isEmpty()) {
            return returnValue;
        }
        Type listType = new TypeToken<List<AlbumResponseModel>>(){}.getType();
        return new ModelMapper().map(albumEntities, listType);
    }
}
