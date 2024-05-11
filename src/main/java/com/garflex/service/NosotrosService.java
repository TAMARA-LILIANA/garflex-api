package com.garflex.service;

import com.garflex.entity.Nosotros;
import com.garflex.repository.NosotrosRepository;
import com.garflex.service.interfaces.INosotrosService;
import com.garflex.Utils.AzureStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NosotrosService implements INosotrosService {
    @Autowired
    private AzureStorageService azureStorage;
    @Autowired
    private NosotrosRepository NosotrosRepository;
    @Transactional
    @Override
    public Nosotros save(Nosotros Nosotros, MultipartFile file) {
        String url = azureStorage.saveFile(file);
        Nosotros.setUrl(url);
        Nosotros.setNombreArchivo(file.getOriginalFilename());
        return NosotrosRepository.save(Nosotros);
    }

    @Transactional
    @Override
    public Nosotros update(Nosotros Nosotros, MultipartFile file) {
        azureStorage.deleteFile(Nosotros.getNombre());
        String url = azureStorage.saveFile(file);
        Nosotros.setUrl(url);
        Nosotros.setNombre(file.getOriginalFilename());
        return NosotrosRepository.save(Nosotros);
    }

    @Transactional(readOnly = true)
    @Override
    public Nosotros findById(Integer id) {
        return NosotrosRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Nosotros> findAll() {
        return NosotrosRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(Nosotros Nosotros) {
        //azureStorage.deleteFile(Nosotros.getNombre());
        NosotrosRepository.delete(Nosotros);
    }

}
