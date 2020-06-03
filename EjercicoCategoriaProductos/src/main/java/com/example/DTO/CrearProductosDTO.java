package com.example.DTO;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CrearProductosDTO {
 
    @Id @GeneratedValue
    private Long id;
 
    private String nombre;
    private String descripcion;
    private String precio;
    private Long categoriaId;
}