package com.garflex.service;

import com.garflex.entity.Producto;
import com.garflex.repository.ProductoRepository;
import com.garflex.service.interfaces.IProductoService;
import com.garflex.Utils.AzureStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private AzureStorageService azureStorage;
    @Autowired
    private ProductoRepository ProductoRepository;
    @Transactional
    @Override
    public Producto save(Producto Producto, MultipartFile file) {
        String url = azureStorage.saveFile(file);
        Producto.setUrl(url);
        Producto.setNombreArchivo(file.getOriginalFilename());
        return ProductoRepository.save(Producto);
    }

    @Transactional
    @Override
    public Producto update(Producto Producto, MultipartFile file) {
        azureStorage.deleteFile(Producto.getNombre());
        String url = azureStorage.saveFile(file);
        Producto.setUrl(url);
        Producto.setNombre(file.getOriginalFilename());
        return ProductoRepository.save(Producto);
    }

    @Transactional(readOnly = true)
    @Override
    public Producto findById(Integer id) {
        return ProductoRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Producto> findByIdType(Integer id) {
        List<Producto> productos = new ArrayList<>();
        for (Producto producto : ProductoRepository.findAll()) {
            if(producto.getTipo() == id){
                productos.add(producto);
            }
        }
        return productos;
    }

    @Override
    public Iterable<Producto> findAll() {
        return ProductoRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(Producto Producto) {
        //azureStorage.deleteFile(Producto.getNombre());
        ProductoRepository.delete(Producto);
    }
    
}
