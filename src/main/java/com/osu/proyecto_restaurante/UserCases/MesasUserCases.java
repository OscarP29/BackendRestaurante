package com.osu.proyecto_restaurante.UserCases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.osu.proyecto_restaurante.UserCases.Mapeadores.Interfaces.MesasMapeadorUserCase;
import com.osu.proyecto_restaurante.domain.MesasDomain;
import com.osu.proyecto_restaurante.domain.SalaMesasDomain;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.MesaEntradaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.SalaMesaEntradaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.MesasSalidaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.SalaMesasSalidaDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MesasUserCases {
    private final MesasMapeadorUserCase mesasMapeadorUserCase;
    private final MesasDomain mesasDomain;
    private final SalaMesasDomain salaMesasDomain;
    
    //Mesas Funciones
    public boolean insertarMesa(MesaEntradaDTO mesaEntradaDTO){
        return mesasDomain.InsertarMesa(mesasMapeadorUserCase.convertirADominio(mesaEntradaDTO));
    }
    public boolean actualizarMesa(MesaEntradaDTO mesaEntradaDTO){
        return mesasDomain.EditarMesa(mesasMapeadorUserCase.convertirADominio(mesaEntradaDTO));
    }
    public boolean eliminarMesa(int id_mesa){
        return mesasDomain.EliminarMesa(id_mesa);
    }
    public boolean cambiarEstadoMesa(int id_mesa, boolean estado_mesa){
        return mesasDomain.CambiarEstadoMesa(id_mesa, estado_mesa);
    }
    public List<MesasSalidaDTO> obtenerMesas(){
        return mesasMapeadorUserCase.convertirListADTO(mesasDomain.ObtenerMesas());
    }

    //Salas Funciones
    public boolean insertarSala(SalaMesaEntradaDTO salaMesaEntradaDTO){
        return salaMesasDomain.InsertarSalaMesas(mesasMapeadorUserCase.convertirADomainSala(salaMesaEntradaDTO));
    }
    public boolean actualizarSala(SalaMesaEntradaDTO salaMesaEntradaDTO){
        return salaMesasDomain.EditarSalaMesas(mesasMapeadorUserCase.convertirADomainSala(salaMesaEntradaDTO));
    }
    public boolean eliminarSala(int id_sala){
        return salaMesasDomain.EliminarSalaMesas(id_sala);
    }
    public List<SalaMesasSalidaDTO> obtenerSalas(){
        return mesasMapeadorUserCase.convertirListADTOSala(salaMesasDomain.ObtenerSalaMesas());
    }
    public String obtenerNombreSala(int id_sala){
        return salaMesasDomain.ObtenerNombreSala(id_sala);
    }
    public int obtenerIdSala(String nombre_sala){
        return salaMesasDomain.ObtenerIdSala(nombre_sala);
    }

}
