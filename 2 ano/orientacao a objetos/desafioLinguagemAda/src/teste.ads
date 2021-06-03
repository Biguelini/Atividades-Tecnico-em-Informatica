-- cria a classe 
package Teste is
-- cria um Tagged Type
   type T is tagged limited private;
-- declarando os métodos públicos
   procedure Init (A : in out T);
   procedure contarPositivos (A : in out T);
   procedure calcularMedia (A : in out T);
   procedure mostrarResultados (A : in out T);
private
-- declarando os atributos privados
   type T is tagged limited record
      valoresPositivos : Integer;
      media, entrada : Float;
   end record;

end Teste;
