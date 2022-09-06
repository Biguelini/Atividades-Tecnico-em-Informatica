#include "colors.inc"
camera {
   location <0, 0, -10>
   look_at <0,0,0>
}      
light_source{
    <0,8,-5>
    color White
        
} 
  
  
  sphere{
    <0,0,0>, 1 
    pigment{ color Red  }
    translate<0,1.3,0>  

}  
  sphere{
    <0,0,0>, 1 
    pigment{ color Red  }  

}                 
cone{
    <0,0,0>, 1
    <0,-2,0>,0
    pigment{ color Brown  } 
    translate<0,-0.25,0>   


}      
 cylinder{
 
 <0,0,0>
   <0,1,0>,0.1
   pigment{ color Brown  }
   rotate<0,0,-25> 
    translate<.5,2,0>  

 }