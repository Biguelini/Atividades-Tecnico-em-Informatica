#include "colors.inc" 
#include "woods.inc"
#include "textures.inc"  
camera {
   location <0, 0, -10>
   look_at <0,0,0>
}      
light_source{
    <0,8,-5>
    color White
        
} 
  
  sphere{
    <0,0.3,0>, 0.99      
            texture{ pigment{ color rgb<0.05,0.65,0.30> }
                 normal { pigment_pattern{ radial 
                                           sine_wave frequency 7 
                                           scale 1.17   
                                           turbulence 0.0 
                                           color_map {[0, rgb 0.15]
                                                      [1, rgb 0.9]}
                                         }
                          1.5  
                        }
                 finish { phong 1  reflection{ 0.15} }
                 rotate<90,0,0>
               }  // end of texture ---------------------------

}  
  sphere{
    <0,2,0>, 0.99      
          texture{ pigment{ gradient <1,1,0>
                            color_map{
                                [ 0.0 color rgb<1,1,1> ]
                                [ 0.5 color rgb<1,1,1> ]
                                [ 0.5 color rgb<1,0,0> ]
                                [ 1.0 color rgb<1,0,0> ]
                               } // end color_map
                             scale 0.3
                           } // end pigment
                 //normal  { bumps 0.5 scale  0.005 }
                   finish  { phong 1 reflection 0.00 }
                 } // end of texture -------------------

}                      
cone{
    <0,0,0>, 1
    <0,-2,0>,0
        texture{ pigment{ color rgb<1,0.42,0.2>*0.5 }
                 normal { dents 6.5 scale 0.1  }
                 finish { specular 0.6 reflection{ 0.00 } }
               } // end of texture


}      
 cylinder{
 
 <0.5,2,0>
   <1,3.5,0>,0.1
           texture{ pigment{ color rgb<1,0.42,0.2>*0.5 }
                 normal { dents 6.5 scale 0.1  }
                 finish { specular 0.6 reflection{ 0.00 } }
               } // end of texture

 }