-- cria a classe 
package PositivosEMedia is
-- cria um Tagged Type
   type P is tagged limited private;
-- declarando os m�todos p�blicos
   procedure Init (A : in out P);
   procedure contarPositivos (A : in out P);
   procedure calcularMedia (A : in out P);
   procedure exibeResultados (A : in out P);
private
-- declarando os atributos privados
   type P is tagged limited record
      valoresPositivos : Integer;
      media, entrada : Float;
   end record;

end PositivosEMedia;
