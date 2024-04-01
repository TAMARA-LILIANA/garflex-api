package com.garflex.service;

import com.garflex.entity.Informacion;
import com.garflex.repository.InformacionRepository;
import com.garflex.service.interfaces.IInformacionService;
import com.garflex.storage.AzureStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class InformacionService implements IInformacionService {
    @Autowired
    private AzureStorageService azureStorage;
    @Autowired
    private InformacionRepository InformacionRepository;
    @Transactional
    @Override
    public Informacion save(Informacion Informacion, MultipartFile file) {
        String url = azureStorage.saveFile(file);
        Informacion.setUrl(url);
        Informacion.setNombreArchivo(file.getOriginalFilename());
        return InformacionRepository.save(Informacion);
    }

    @Transactional
    @Override
    public Informacion update(Informacion Informacion, MultipartFile file) {
        azureStorage.deleteFile(Informacion.getNombreArchivo());
        String url = azureStorage.saveFile(file);
        Informacion.setUrl(url);
        Informacion.setNombreArchivo(file.getOriginalFilename());
        return InformacionRepository.save(Informacion);
    }

    @Transactional(readOnly = true)
    @Override
    public Informacion findById(Integer id) {
        return InformacionRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Informacion> findAll() {
        return InformacionRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(Informacion Informacion) {

        InformacionRepository.delete(Informacion);
    }
    
}
