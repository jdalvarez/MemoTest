package com.example.memotest

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.memotest.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var listImageViewBroken = ArrayList<ImageView>()
    var listImageView = ArrayList <ImageView>()
    var positionList = ArrayList<Int>()
    var imgClassList = ArrayList<Image>()

    var img1 = Image()
    var img2 = Image()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listImageView.add(binding.img0)
        listImageView.add(binding.img1)
        listImageView.add(binding.img2)
        listImageView.add(binding.img3)
        listImageView.add(binding.img4)
        listImageView.add(binding.img5)
        listImageView.add(binding.img6)
        listImageView.add(binding.img7)
        listImageView.add(binding.img8)
        listImageView.add(binding.img9)

        listImageViewBroken.add(binding.img0Rota)
        listImageViewBroken.add(binding.img1Rota)
        listImageViewBroken.add(binding.img2Rota)
        listImageViewBroken.add(binding.img3Rota)
        listImageViewBroken.add(binding.img4Rota)
        listImageViewBroken.add(binding.img5Rota)
        listImageViewBroken.add(binding.img6Rota)
        listImageViewBroken.add(binding.img7Rota)
        listImageViewBroken.add(binding.img8Rota)
        listImageViewBroken.add(binding.img9Rota)

        ocultarImg()
        positionRandom()
       // showImg()
    }
    fun ocultarImg(){
        for(i in 0..9){
            listImageViewBroken[i].visibility = View.VISIBLE
            listImageView[i].visibility = View.INVISIBLE
        }
    }

    fun showImg(){
        for(i in 0..9){
            listImageViewBroken[i].visibility = View.INVISIBLE
            listImageView[i].visibility = View.VISIBLE
        }
    }

    fun positionRandom(){
        positionList.add(0)
        positionList.add(1)
        positionList.add(2)
        positionList.add(3)
        positionList.add(4)
        positionList.add(5)
        positionList.add(6)
        positionList.add(7)
        positionList.add(8)
        positionList.add(9)
        //Muestra Array en orden
        Log.d("mensaje","ORIGINAL $positionList")
        //Desordenar Array
        Collections.shuffle(positionList)
        //Muestra array desordenado
        Log.d("mensaje","ORIGINAL $positionList")

        imgClassList.add(Image())
        imgClassList.add(Image())
        imgClassList.add(Image())
        imgClassList.add(Image())
        imgClassList.add(Image())
        imgClassList.add(Image())
        imgClassList.add(Image())
        imgClassList.add(Image())
        imgClassList.add(Image())
        imgClassList.add(Image())
        //cada imagen debe tener 2 posiciones
        for(i in 0..9){
            var position = positionList[i]
            var id_drawable = 0

            when(i){
                0,1->{
                    id_drawable = R.drawable.ic_anchor
                }
                2,3->{
                    id_drawable = R.drawable.ic_bus
                }
                4,5->{
                    id_drawable = R.drawable.ic_plane
                }
                6,7->{
                    id_drawable = R.drawable.ic_sun
                }
                8,9->{
                    id_drawable = R.drawable.ic_tractor
                }
            }

            //Af=gregar las img a Imageview
            listImageView[position].setImageResource(id_drawable)
            var obImg = Image().apply{
                this.idvector=id_drawable
            }

            //Ponemos las imagenes en su posicion
            imgClassList[position] = obImg
        }
    }

    fun porecesarImg(imgView:View){
        var positionSelect = imgView.tag.toString().toInt()     //recupero el tag del xml
        var id = imgView.resources.getResourceEntryName(imgView.id)     //recupero el nombre del id
        if(imgView is ImageView){
            when(id){
                "img0Rota"->{
                    mostrarOcultarImg(positionSelect,true)
                }
                "img1Rota"->{
                    mostrarOcultarImg(positionSelect,true)
                }
                "img2Rota"->{
                    mostrarOcultarImg(positionSelect,true)
                }
                "img3Rota"->{
                    mostrarOcultarImg(positionSelect,true)
                }
                "img4Rota"->{
                    mostrarOcultarImg(positionSelect,true)
                }
                "img5Rota"->{
                    mostrarOcultarImg(positionSelect,true)
                }
                "img6Rota"->{
                    mostrarOcultarImg(positionSelect,true)
                }
                "img7Rota"->{
                    mostrarOcultarImg(positionSelect,true)
                }
                "img8Rota"->{
                    mostrarOcultarImg(positionSelect,true)
                }
                "img9Rota"->{
                    mostrarOcultarImg(positionSelect,true)
                }
                "img0"->{
                    mostrarOcultarImg(positionSelect,false)
                }
                "img1"->{
                    mostrarOcultarImg(positionSelect,false)
                }
                "img2"->{
                    mostrarOcultarImg(positionSelect,false)
                }
                "img3"->{
                    mostrarOcultarImg(positionSelect,false)
                }
                "img4"->{
                    mostrarOcultarImg(positionSelect,false)
                }
                "img5"->{
                    mostrarOcultarImg(positionSelect,false)
                }
                "img6"->{
                    mostrarOcultarImg(positionSelect,false)
                }
                "img7"->{
                    mostrarOcultarImg(positionSelect,false)
                }
                "img8"->{
                    mostrarOcultarImg(positionSelect,false)
                }
                "img9"->{
                    mostrarOcultarImg(positionSelect,false)
                }
            }
        }
        asignImg(positionSelect)
    }

    fun mostrarOcultarImg(position:Int, mostrar:Boolean){
        if(mostrar){
            listImageView[position].visibility = View.VISIBLE
            listImageViewBroken[position].visibility = View.INVISIBLE
        }else{
            listImageView[position].visibility = View.INVISIBLE
            listImageViewBroken[position].visibility = View.VISIBLE
        }
    }

    fun asignImg(position: Int){
        if(img1.asignated){
            img2 = imgClassList[position]
            img2.position = position
            img2.asignated = true
            if(img1.idvector == img2.idvector){
                shoMsj("Genial!")
            }else{
                Handler().postDelayed({
                    shoMsj("Intente de nuevo")
                    mostrarOcultarImg(img1.position, false)
                    mostrarOcultarImg(img2.position, false)
                                    }, 800)

            }
            img1.asignated = false
            img2.asignated = false
        }else{
            img1 = imgClassList[position]
            img1.asignated = true
            img1.position = position
        }
    }

    fun shoMsj(msj:String){
        Toast.makeText(this, msj,Toast.LENGTH_SHORT).show()
    }

    fun resetGame(view: View) {
        var intent = getIntent()
        finish()
        startActivity(intent)
    }


}