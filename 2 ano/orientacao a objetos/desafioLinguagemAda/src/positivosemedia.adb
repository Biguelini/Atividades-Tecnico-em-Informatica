with Text_IO; use Text_IO;
package body PositivosEMedia is
-- criando os métodos em si
   procedure Init (A : in out P) is
   begin
      A.valoresPositivos := 0 ;
      A.media := 0.0;
      
   end Init;
   procedure contarPositivos (A : in out P) is
   begin
      for I in 0 .. 5 loop
         A.entrada := Float'Value(Get_Line);
         if A.entrada > 0.0 then
            A.media := A.media + A.entrada;
            A.valoresPositivos := A.valoresPositivos + 1;
         end if;
      end loop;
	
   end contarPositivos;
   procedure calcularMedia (A : in out P) is
      begin
         A.media := A.media / Float(A.valoresPositivos);
   end calcularMedia;
   procedure exibeResultados (A : in out P) is
      begin
         Put_Line(Integer'Image (A.valoresPositivos)&" valores positivos");
         Put_Line(Float'Image (A.media));
   end exibeResultados;
end PositivosEMedia;
