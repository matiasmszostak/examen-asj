package com.asj.examen.examenbackend.services;

import com.asj.examen.examenbackend.exceptions.producto.ProductoNoExisteException;
import com.asj.examen.examenbackend.exceptions.vendedor.VendedorNoExisteException;
import com.asj.examen.examenbackend.exceptions.venta.VentaNoExisteException;
import com.asj.examen.examenbackend.exceptions.venta.VentaYaExisteException;
import com.asj.examen.examenbackend.models.Producto;
import com.asj.examen.examenbackend.models.Vendedor;
import com.asj.examen.examenbackend.models.Venta;
import com.asj.examen.examenbackend.repositories.VentaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImp implements VentaService{



    //El Logger sirve para hacer un seguimiento de errores. Usamos el de la librería slf4j
    private Logger logger = LoggerFactory.getLogger(VentaServiceImp.class);

    public VentaServiceImp() {
        logger.info("Se inicializa VentaServiceImp");
    }



    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private ProductoService productoService;




    @Override
    public Optional<Venta> buscarVentaPor(Long id) throws VentaNoExisteException{
        if (!this.ventaRepository.findVentaById(id).isPresent()) {
            throw new VentaNoExisteException("El vendedor con el id " + id + "no existe");
        } else {
            return this.ventaRepository.findVentaById(id);
        }
    }

    @Override
    public Iterable<Venta> listarTodasLasVentas() {
        return this.ventaRepository.findAll();
    }

    @Override
    public Venta altaNuevaVenta(Venta venta) throws Exception {
        if (venta != null) {
            if (venta.getId() != null) {
                if (this.ventaRepository.findById(venta.getId()).isPresent()) {
                    throw new VentaYaExisteException("La venta con el id " + venta.getId() + "ya existe");
                }
            }
        }

        //Set total
        Optional<Producto> productoBuscado = this.productoService
                .buscarProductoPor(venta.getProducto().getId());

        if(productoBuscado == null){
            throw new ProductoNoExisteException("No se halló el producto");
        }

        //Busco producto
        Producto producto = productoBuscado.get();
        venta.setTotal(producto.getPrecio());


        //Busco vendedor
        Optional<Vendedor> vendedorBuscado = this.vendedorService
                .buscarVendedorPor(venta.getVendedor().getId());

        if(vendedorBuscado == null){
            throw new VendedorNoExisteException("No se halló al vendedor");
        }

        //Guardo venta
        Venta resultado = this.ventaRepository.save(venta);


        //Actualizo comisiones del vendedor
        Double comisionVentaActualizada = this.comisionPorcentaje(venta);

        Vendedor vendedor = vendedorBuscado.get();
        vendedor.setComision(comisionVentaActualizada);

        //actualizo el sueldo total
        vendedor.setSueldoTotal(vendedor.getSueldoBasico()+vendedor.getComision());

        //Guardo los cambios en el vendedor
        this.vendedorService.actualizarVendedor(vendedor.getId(), vendedor);

        //Devuelvo la venta
        return resultado;
    }


    private Double comisionPorcentaje(Venta venta) {
        List<Venta> ventasVendedor = (List<Venta>) this.ventaRepository
                .findVentaByIdVendedor(venta.getVendedor().getId());

        Double ventasTotal = 0.0;
        for (Venta v : ventasVendedor) {
            ventasTotal += v.getTotal();
        }

        if (ventasVendedor.size() < 3) {
            return ventasTotal * 0.05;
        } else {
            return ventasTotal * 0.1;
        }
    }


}