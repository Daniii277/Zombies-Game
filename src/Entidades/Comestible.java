/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Entidades;

public interface Comestible {
    //when a entity that implements this interface is eaten by a zombie, the zombie's hunger is reduced to 0 if the entity is a human, and reduced 1 unit if its a rabbit.
   public void eaten();
}

