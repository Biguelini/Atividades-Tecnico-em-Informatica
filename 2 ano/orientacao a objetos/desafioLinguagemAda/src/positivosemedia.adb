with Text_IO; use Text_IO;
package body Teste is
-- criando os métodos em si
   procedure Init (A : in out T) is
   begin
      A.valoresPositivos := 0 ;
      A.media := 0.0;
      
   end Init;
   procedure contarPositivos (A : in out T) is
   begin
      for I in 0 .. 5 loop
         A.entrada := Float'Value(Get_Line);
         if A.entrada > 0.0 then
            A.media := A.media + A.entrada;
            A.valoresPositivos := A.valoresPositivos + 1;
         end if;
      end loop;
	
   end contarPositivos;
   procedure calcularMedia (A : in out T) is
      begin
         A.media := A.media / Float(A.valoresPositivos);
   end calcularMedia;
   procedure mostrarResultados (A : in out T) is
      begin
         Put_Line(Integer'Image (A.valoresPositivos)&" valores positivos");
         Put_Line(Float'Image (A.media));
   end mostrarResultados;
end Teste;
