package com.garflex.service;

import com.garflex.entity.Carrusel;
import com.garflex.repository.CarruselRepository;
import com.garflex.service.interfaces.ICarruselService;
import com.garflex.storage.AzureStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CarruselService implements ICarruselService {

    @Autowired
    private AzureStorageService azureStorage;
    @Autowired
    private CarruselRepository carruselRepository;
    @Transactional
    @Override
    public Carrusel save(Carrusel carrusel, MultipartFile file) {
        String url = azureStorage.saveFile(file);
        carrusel.setUrl(url);
        carrusel.setNombreArchivo(file.getOriginalFilename());
        return carruselRepository.save(carrusel);
    }

    @Transactional
    @Override
    public Carrusel update(Carrusel carrusel, MultipartFile file) {
        azureStorage.deleteFile(carrusel.getNombreArchivo());
        String url = azureStorage.saveFile(file);
        carrusel.setUrl(url);
        carrusel.setNombreArchivo(file.getOriginalFilename());
        return carruselRepository.save(carrusel);
    }

    @Transactional(readOnly = true)
    @Override
    public Carrusel findById(Integer id) {
        return carruselRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Carrusel> findAll() {
        return carruselRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(Carrusel carrusel) {

        carruselRepository.delete(carrusel);
    }
}
