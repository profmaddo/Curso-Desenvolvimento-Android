<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class MediaEscolar extends Model
{
    // Nome da tabela no banco de dados
    protected $table = 'mediaescolar';

    // Os campos serão preenchidos automaticamente
    protected $fillatle = ['id'];
    //protected $fillatle = ['id','bimestre'];

    // Os campos não preenchidos automaticamente
    //protected $guarded = não preenchidos automaticamente

}
