#include "colors.inc"  
#include "glass.inc"
camera {
   location <-10, 40, -100>
   look_at <0,0,0>
}      
light_source{
    <0,100,-100>
    color White
        
}             
sky_sphere{
    pigment{
        gradient y
        color_map{
            [0 color Red]
            [0.3 color Yellow]
        }
    }
}             
plane{
    <0,1,0>, 0
    pigment {
        color Green
    }
    

} 
difference{
    difference{
        box{
            <0,0,0>
            <30,30,30>
            pigment{color Red}
        
        }   
        
        box{
            <2,0.2,2>
            <28,28,28>
            pigment{color White}
        
        } 
        box{
            <5,0,-0.1>
            <15,18,2.1>
            pigment{color Yellow}
        
        }                  
      
    }
     box{
        <18,10,-0.1>
        <28,20,2.1>
        texture{ pigment{ rgbf <0.98, 0.98, 0.98, 0.9> }
            finish { diffuse 0.1 reflection 0.2  
                 specular 0.8 roughness 0.0003 phong 1 phong_size 400}
       } // end of texture -------------------------------------------



    }   
    box{
        <15,15,17>
        <-15,-15,-17>
        pigment{color Red}
        rotate<0,0,-70>
        translate<0,38,15> 
    
    } 
    box{
        <15,15,17>
        <-15,-15,-17>
        pigment{color Red}
        rotate<0,0,70>
        translate<30,38,15> 
    
    }       
     
}
box{
    <15,2,17>
    <-15,-2,-17>
    pigment{color Red}
    rotate<0,0,30>
    translate<3,22,15> 

} 
box{
    <15,2,17>
    <-15,-2,-17>
    pigment{color Red}
    rotate<0,0,-30>
    translate<27,22,15> 

}

  