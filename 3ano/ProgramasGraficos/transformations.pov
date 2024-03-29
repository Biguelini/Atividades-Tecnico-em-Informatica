#include "colors.inc"
camera {
   location <0, 0, -10>
   look_at <0,0,0>
}      
light_source{
    <0,8,-5>
    color White
        
} 
  
box{
    <-1,-1,-1>
    <1,1,1>
    pigment{color Red}
        translate<-3,2,0>
    rotate<45,0,0>
    scale<2,2,2>  
              texture{ 
              rotate<45,60,35>
              
              pigment{ gradient <1,1,0>
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