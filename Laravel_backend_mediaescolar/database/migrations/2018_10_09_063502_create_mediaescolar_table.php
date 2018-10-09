<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateMediaescolarTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('mediaescolar', function (Blueprint $table) {
            $table->increments('id');
            $table->string('materia',35);
            $table->string('bimestre',15);
            $table->string('situacao',12);
            $table->double('notaProva',5,2);
            $table->double('notaTrabalho',5,2);
            $table->double('notaFinal',5,2);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('mediaescolar');
    }
}
