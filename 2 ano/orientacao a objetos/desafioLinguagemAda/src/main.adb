with Text_IO; use Text_IO;
procedure Main is
   type My_Task (First : Character);
   begin
      for I in First .. 'Z' loop
         Put_Line (I);
      end loop;

   Tab : array (0 .. 9) of My_Task ('G');
begin
   null;
end Main;
