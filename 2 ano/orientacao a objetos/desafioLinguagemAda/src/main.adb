with Text_IO; use Text_IO;
procedure Main is
   package Persons is
   type Person is tagged
      record
         Name   : String (1 .. 10);
         Gender : Gender_Type;
      end record;
   end Persons;
begin
   null;
end Main;
