package mx.tecm.iigs.ladm_u2_p2_loteria_17400983_igbiidair

import kotlin.random.Random

class Loteria(cartas:MutableList<Int>,act:MainActivity):Thread() {
    var pausar=false
    var ejecutar=true
    var cartas=cartas
    var act=act
    var x=54

    override fun run() {
        super.run()
        while (ejecutar){
            if(!pausar){
                if(cartas.size>0) {
                    act.runOnUiThread{
                        var random = Random.nextInt(x)
                        act.binding.baraja.setImageResource(cartas[random])
                        cartas.removeAt(random)
                        x--
                        sleep(1000)
                    }
                }
                if(cartas.size==0){
                    act.runOnUiThread{
                        terminarhilo()
                    }
                }
                sleep(3000)
            }
        }
    }

    fun terminarhilo(){
        ejecutar=false
    }
    fun pausarHilo(){
        pausar=true

    }
    fun despausarHilo(){
        pausar=false
    }
    fun estaPausado():Boolean{
        return pausar
    }

}
