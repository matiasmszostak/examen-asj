package com.asj.examen.examenbackend.services;


import com.asj.examen.examenbackend.exceptions.producto.ProductoNoExisteException;
import com.asj.examen.examenbackend.models.Producto;
import com.asj.examen.examenbackend.repositories.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoServiceImp implements ProductoService{

    //El Logger sirve para hacer un seguimiento de errores. Usamos el de la librería slf4j.
    private Logger logger = LoggerFactory.getLogger(ProductoServiceImp.class);

    public ProductoServiceImp() {
        logger.info("Se inicializa ProductoServiceImp");
    }

    @Autowired
    private ProductoRepository productoRepositorio;



    @Override
    public Optional<Producto> buscarProductoPor(Long id) throws ProductoNoExisteException {
        if(!this.productoRepositorio.findProductoById(id).isPresent()){
            throw new ProductoNoExisteException("El producto con el id " + id + "no existe");
        }else {
            return this.productoRepositorio.findProductoById(id);
        }

    }
    /*
 @Override
    public Optional<Producto> buscarPorId(Long id) throws NoExisteException {
        if(!this.repo.findById(id).isPresent()){
            throw new NoExisteException("No existe producto con id ["+id+"]");
        } else {
            return this.repo.findById(id);
        }
    }
*/
    @Override
    public Iterable<Producto> buscarProductoPor(String categoria) {
        return this.productoRepositorio.findAllByCategoria(categoria);
    };



    @Override
    public Producto altaNuevoProducto(Producto producto) throws Exception {
        if(this.productoRepositorio
                .findProductoByNombre(producto.getNombre()).isPresent()){
            throw new Exception("El producto con el nombre "+ producto.getNombre() + ", ya existe");
        }
        return this.productoRepositorio.save(producto);
    }

}
