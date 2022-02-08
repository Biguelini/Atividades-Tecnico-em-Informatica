/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.santanapg.crud.repository;

/**
 *
 * @author 2info2021
 */
import br.com.santanapg.crud.vo.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ContatoRepository extends JpaRepository<Contato, Integer>{
    
}
