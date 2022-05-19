package com.example.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.test1.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding;
    var brojPreskocenihPrvog = 0;
    var brojPreskocenihDrugog = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        var prviOdigraoZadnjiPotez = true;

        fun generisiBroj(lista: Array<Int>):Int {
            var broj = Random.nextInt(1, 51)
            while(true) {
                if(lista.contains(broj)) {
                    broj = Random.nextInt(1, 51);
                }
                else {
                    return broj;
                }
            }
        }

        fun provjeraKrajaIgre(zadnjiPotez: Int, igraPrvi:Boolean) {
            if(igraPrvi) {

                var dugme1 = binding.igrac2dugme1.text.toString().toInt()
                var dugme2 = binding.igrac2dugme2.text.toString().toInt()
                var dugme3 = binding.igrac2dugme3.text.toString().toInt()
                var dugme4 = binding.igrac2dugme4.text.toString().toInt()
                var dugme5 = binding.igrac2dugme5.text.toString().toInt()
                if (dugme1 < zadnjiPotez && dugme2 < zadnjiPotez && dugme3 < zadnjiPotez && dugme4 < zadnjiPotez && dugme5 < zadnjiPotez && brojPreskocenihDrugog == 2) {
                    binding.igrac1dugme1.isEnabled = false
                    binding.igrac1dugme2.isEnabled = false
                    binding.igrac1dugme3.isEnabled = false
                    binding.igrac1dugme4.isEnabled = false
                    binding.igrac1dugme5.isEnabled = false

                    binding.igrac2dugme1.isEnabled = false
                    binding.igrac2dugme2.isEnabled = false
                    binding.igrac2dugme3.isEnabled = false
                    binding.igrac2dugme4.isEnabled = false
                    binding.igrac2dugme5.isEnabled = false

                    binding.preskociPotez.isEnabled = false


                    Toast.makeText(applicationContext, "Igrac 1 je pobijedio", Toast.LENGTH_SHORT)
                        .show()
                }

            }
            else {

                var dugme1 = binding.igrac1dugme1.text.toString().toInt()
                var dugme2 = binding.igrac1dugme2.text.toString().toInt()
                var dugme3 = binding.igrac1dugme3.text.toString().toInt()
                var dugme4 = binding.igrac1dugme4.text.toString().toInt()
                var dugme5 = binding.igrac1dugme5.text.toString().toInt()
                if (dugme1 < zadnjiPotez && dugme2 < zadnjiPotez && dugme3 < zadnjiPotez && dugme4 < zadnjiPotez && dugme5 < zadnjiPotez && brojPreskocenihPrvog == 2) {
                    binding.igrac1dugme1.isEnabled = false
                    binding.igrac1dugme2.isEnabled = false
                    binding.igrac1dugme3.isEnabled = false
                    binding.igrac1dugme4.isEnabled = false
                    binding.igrac1dugme5.isEnabled = false

                    binding.igrac2dugme1.isEnabled = false
                    binding.igrac2dugme2.isEnabled = false
                    binding.igrac2dugme3.isEnabled = false
                    binding.igrac2dugme4.isEnabled = false
                    binding.igrac2dugme5.isEnabled = false

                    binding.preskociPotez.isEnabled = false


                    Toast.makeText(applicationContext, "Igrac 2 je pobijedio", Toast.LENGTH_SHORT)
                        .show()
                }

            }
        }






        var igraPrvi = true;
        var brojeviPrvog = arrayOf<Int>()
        var brojeviDrugog = arrayOf<Int>()
        var generisaniBrojevi = arrayOf<Int>()

        for (i in 0..5) {
            var broj = Random.nextInt(1,51)
            while(true) {
                if(brojeviPrvog.contains(broj)) {
                    broj = Random.nextInt(1, 51);
                }
                else {
                    brojeviPrvog += broj;
                    generisaniBrojevi += broj;
                    break;
                }
            }
        }


        for (i in 0..5) {
            var broj = Random.nextInt(1,51)
            while(true) {
                if(generisaniBrojevi.contains(broj)) {
                    broj = Random.nextInt(1, 51);
                }
                else {
                    brojeviDrugog += broj;
                    generisaniBrojevi += broj;
                    break;
                }
            }
        }

        for (i in 0..5) {
            when (i) {
                0 -> {binding.igrac1dugme1.text = brojeviPrvog.elementAt(i).toString()
                      binding.igrac2dugme1.text = brojeviDrugog.elementAt(i).toString()
                }
                1 -> {binding.igrac1dugme2.text = brojeviPrvog.elementAt(i).toString()
                    binding.igrac2dugme2.text = brojeviDrugog.elementAt(i).toString()
                }
                2 -> {binding.igrac1dugme3.text = brojeviPrvog.elementAt(i).toString()
                    binding.igrac2dugme3.text = brojeviDrugog.elementAt(i).toString()
                }
                3 -> {binding.igrac1dugme4.text = brojeviPrvog.elementAt(i).toString()
                    binding.igrac2dugme4.text = brojeviDrugog.elementAt(i).toString()
                }
                4 -> {binding.igrac1dugme5.text = brojeviPrvog.elementAt(i).toString()
                    binding.igrac2dugme5.text = brojeviDrugog.elementAt(i).toString()
                }


            }
        }
        binding.igrac1dugme1.setOnClickListener {
            if(igraPrvi && binding.igrac1dugme1.text.toString().toInt() > binding.zadnjiPotez.text.toString().toInt()) {
                binding.zadnjiPotez.text = binding.igrac1dugme1.text.toString();
                val noviBroj = generisiBroj(generisaniBrojevi);
                binding.igrac1dugme1.text = noviBroj.toString()

                generisaniBrojevi += noviBroj;
                provjeraKrajaIgre(binding.zadnjiPotez.text.toString().toInt(), igraPrvi);
                igraPrvi = false;


                prviOdigraoZadnjiPotez = true;
            }
            else {
                Toast.makeText(applicationContext,"Neispravan potez",Toast.LENGTH_SHORT).show()
            }
        }
        binding.igrac1dugme2.setOnClickListener {
            if(igraPrvi && binding.igrac1dugme2.text.toString().toInt() > binding.zadnjiPotez.text.toString().toInt()) {
                binding.zadnjiPotez.text = binding.igrac1dugme2.text.toString();
                val noviBroj = generisiBroj(generisaniBrojevi);
                binding.igrac1dugme2.text = noviBroj.toString()

                generisaniBrojevi += noviBroj;

                provjeraKrajaIgre(binding.zadnjiPotez.text.toString().toInt(), igraPrvi);
                igraPrvi = false;


                prviOdigraoZadnjiPotez = true;
            }
            else {
                Toast.makeText(applicationContext,"Neispravan potez",Toast.LENGTH_SHORT).show()
            }
        }
        binding.igrac1dugme3.setOnClickListener {
            if(igraPrvi && binding.igrac1dugme3.text.toString().toInt() > binding.zadnjiPotez.text.toString().toInt()) {
                binding.zadnjiPotez.text = binding.igrac1dugme3.text.toString();
                val noviBroj = generisiBroj(generisaniBrojevi);
                binding.igrac1dugme3.text = noviBroj.toString()

                generisaniBrojevi += noviBroj;

                provjeraKrajaIgre(binding.zadnjiPotez.text.toString().toInt(), igraPrvi);
                igraPrvi = false;

                prviOdigraoZadnjiPotez = true;
            }
            else {
                Toast.makeText(applicationContext,"Neispravan potez",Toast.LENGTH_SHORT).show()
            }
        }

        binding.igrac1dugme4.setOnClickListener {
            if(igraPrvi && binding.igrac1dugme4.text.toString().toInt() > binding.zadnjiPotez.text.toString().toInt()) {
                binding.zadnjiPotez.text = binding.igrac1dugme4.text.toString();
                val noviBroj = generisiBroj(generisaniBrojevi);
                binding.igrac1dugme4.text = noviBroj.toString()

                generisaniBrojevi += noviBroj;

                provjeraKrajaIgre(binding.zadnjiPotez.text.toString().toInt(), igraPrvi);
                igraPrvi = false;



                prviOdigraoZadnjiPotez = true;

            }
            else {
                Toast.makeText(applicationContext,"Neispravan potez",Toast.LENGTH_SHORT).show()
            }
        }
        binding.igrac1dugme5.setOnClickListener {
            if(igraPrvi && binding.igrac1dugme5.text.toString().toInt() > binding.zadnjiPotez.text.toString().toInt()) {
                binding.zadnjiPotez.text = binding.igrac1dugme5.text.toString();
                val noviBroj = generisiBroj(generisaniBrojevi);
                binding.igrac1dugme5.text = noviBroj.toString()

                generisaniBrojevi += noviBroj;

                provjeraKrajaIgre(binding.zadnjiPotez.text.toString().toInt(), igraPrvi);
                igraPrvi = false;



                prviOdigraoZadnjiPotez = true;
            }
            else {
                Toast.makeText(applicationContext,"Neispravan potez",Toast.LENGTH_SHORT).show()
            }
        }

        binding.igrac2dugme1.setOnClickListener {
            if(!igraPrvi && binding.igrac2dugme1.text.toString().toInt() > binding.zadnjiPotez.text.toString().toInt()) {
                binding.zadnjiPotez.text = binding.igrac2dugme1.text.toString();
                val noviBroj = generisiBroj(generisaniBrojevi);
                binding.igrac2dugme1.text = noviBroj.toString()

                generisaniBrojevi += noviBroj;

                provjeraKrajaIgre(binding.zadnjiPotez.text.toString().toInt(), igraPrvi);
                igraPrvi = true;


                prviOdigraoZadnjiPotez = false;
            }
            else {
                Toast.makeText(applicationContext,"Neispravan potez",Toast.LENGTH_SHORT).show()
            }
        }

        binding.igrac2dugme2.setOnClickListener {
            if(!igraPrvi && binding.igrac2dugme2.text.toString().toInt() > binding.zadnjiPotez.text.toString().toInt()) {
                binding.zadnjiPotez.text = binding.igrac2dugme2.text.toString();
                val noviBroj = generisiBroj(generisaniBrojevi);
                binding.igrac2dugme2.text = noviBroj.toString()

                generisaniBrojevi += noviBroj;

                provjeraKrajaIgre(binding.zadnjiPotez.text.toString().toInt(), igraPrvi);
                igraPrvi = true;

                prviOdigraoZadnjiPotez = false;
            }
            else {
                Toast.makeText(applicationContext,"Neispravan potez",Toast.LENGTH_SHORT).show()
            }
        }

        binding.igrac2dugme3.setOnClickListener {
            if(!igraPrvi && binding.igrac2dugme3.text.toString().toInt() > binding.zadnjiPotez.text.toString().toInt()) {
                binding.zadnjiPotez.text = binding.igrac2dugme3.text.toString();
                val noviBroj = generisiBroj(generisaniBrojevi);
                binding.igrac2dugme3.text = noviBroj.toString()

                generisaniBrojevi += noviBroj;

                provjeraKrajaIgre(binding.zadnjiPotez.text.toString().toInt(), igraPrvi);
                igraPrvi = true;

                prviOdigraoZadnjiPotez = false;
            }
            else {
                Toast.makeText(applicationContext,"Neispravan potez",Toast.LENGTH_SHORT).show()
            }
        }

        binding.igrac2dugme4.setOnClickListener {
            if(!igraPrvi && binding.igrac2dugme4.text.toString().toInt() > binding.zadnjiPotez.text.toString().toInt()) {
                binding.zadnjiPotez.text = binding.igrac2dugme4.text.toString();
                val noviBroj = generisiBroj(generisaniBrojevi);
                binding.igrac2dugme4.text = noviBroj.toString()

                generisaniBrojevi += noviBroj;

                provjeraKrajaIgre(binding.zadnjiPotez.text.toString().toInt(), igraPrvi);
                igraPrvi = true;

                prviOdigraoZadnjiPotez = false;
            }
            else {
                Toast.makeText(applicationContext,"Neispravan potez",Toast.LENGTH_SHORT).show()
            }

        }

        binding.igrac2dugme5.setOnClickListener {
            if(!igraPrvi && binding.igrac2dugme5.text.toString().toInt() > binding.zadnjiPotez.text.toString().toInt()) {
                binding.zadnjiPotez.text = binding.igrac2dugme5.text.toString();
                val noviBroj = generisiBroj(generisaniBrojevi);
                binding.igrac2dugme5.text = noviBroj.toString()

                generisaniBrojevi += noviBroj;

                provjeraKrajaIgre(binding.zadnjiPotez.text.toString().toInt(), igraPrvi);
                igraPrvi = true;
                prviOdigraoZadnjiPotez = false;
            }
            else {
                Toast.makeText(applicationContext,"Neispravan potez",Toast.LENGTH_SHORT).show()
            }
        }

        binding.preskociPotez.setOnClickListener {
            if(igraPrvi && brojPreskocenihPrvog <= 1) {
                brojPreskocenihPrvog += 1

                var broj = generisiBroj(generisaniBrojevi)
                var karta = Random.nextInt(1, 6);
                when(karta) {
                    1 -> binding.igrac1dugme1.text = broj.toString()

                    2 -> binding.igrac1dugme2.text = broj.toString()

                    3 -> binding.igrac1dugme3.text = broj.toString()

                    4 -> binding.igrac1dugme4.text = broj.toString()

                    5 -> binding.igrac1dugme1.text = broj.toString()
                }
                var zadnjiPotez = binding.zadnjiPotez.text.toString().toInt()
                var dugme1 = binding.igrac1dugme1.text.toString().toInt()
                var dugme2 = binding.igrac1dugme2.text.toString().toInt()
                var dugme3 = binding.igrac1dugme3.text.toString().toInt()
                var dugme4 = binding.igrac1dugme4.text.toString().toInt()
                var dugme5 = binding.igrac1dugme5.text.toString().toInt()
                if (dugme1 < zadnjiPotez && dugme2 < zadnjiPotez && dugme3 < zadnjiPotez && dugme4 < zadnjiPotez && dugme5 < zadnjiPotez && brojPreskocenihPrvog == 2) {
                    binding.igrac1dugme1.isEnabled = false
                    binding.igrac1dugme2.isEnabled = false
                    binding.igrac1dugme3.isEnabled = false
                    binding.igrac1dugme4.isEnabled = false
                    binding.igrac1dugme5.isEnabled = false

                    binding.igrac2dugme1.isEnabled = false
                    binding.igrac2dugme2.isEnabled = false
                    binding.igrac2dugme3.isEnabled = false
                    binding.igrac2dugme4.isEnabled = false
                    binding.igrac2dugme5.isEnabled = false

                    binding.preskociPotez.isEnabled = false


                    Toast.makeText(applicationContext, "Igrac 2 je pobijedio", Toast.LENGTH_SHORT).show()

                }

                igraPrvi = false
            }
            else if(!igraPrvi && brojPreskocenihDrugog <= 1) {
                brojPreskocenihDrugog += 1

                var broj = generisiBroj(generisaniBrojevi)
                var karta = Random.nextInt(1, 6);
                when(karta) {
                    1 -> binding.igrac2dugme1.text = broj.toString()

                    2 -> binding.igrac2dugme2.text = broj.toString()

                    3 -> binding.igrac2dugme3.text = broj.toString()

                    4 -> binding.igrac2dugme4.text = broj.toString()

                    5 -> binding.igrac2dugme1.text = broj.toString()
                }

                    var zadnjiPotez = binding.zadnjiPotez.text.toString().toInt()
                    var dugme1 = binding.igrac2dugme1.text.toString().toInt()
                    var dugme2 = binding.igrac2dugme2.text.toString().toInt()
                    var dugme3 = binding.igrac2dugme3.text.toString().toInt()
                    var dugme4 = binding.igrac2dugme4.text.toString().toInt()
                    var dugme5 = binding.igrac2dugme5.text.toString().toInt()
                    if (dugme1 < zadnjiPotez && dugme2 < zadnjiPotez && dugme3 < zadnjiPotez && dugme4 < zadnjiPotez && dugme5 < zadnjiPotez && brojPreskocenihDrugog == 2) {
                        binding.igrac1dugme1.isEnabled = false
                        binding.igrac1dugme2.isEnabled = false
                        binding.igrac1dugme3.isEnabled = false
                        binding.igrac1dugme4.isEnabled = false
                        binding.igrac1dugme5.isEnabled = false

                        binding.igrac2dugme1.isEnabled = false
                        binding.igrac2dugme2.isEnabled = false
                        binding.igrac2dugme3.isEnabled = false
                        binding.igrac2dugme4.isEnabled = false
                        binding.igrac2dugme5.isEnabled = false

                        binding.preskociPotez.isEnabled = false


                        Toast.makeText(applicationContext, "Igrac 1 je pobijedio", Toast.LENGTH_SHORT).show()

                }

                igraPrvi = true
            }
        }

        binding.zadnjiPotez.isEnabled = false;
    }
}