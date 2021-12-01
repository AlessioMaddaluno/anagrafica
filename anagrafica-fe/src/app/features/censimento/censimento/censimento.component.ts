import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, AbstractControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { PersonaService } from 'src/app/core/services/persona.service';

@Component({
  selector: 'app-censimento',
  templateUrl: './censimento.component.html',
  styleUrls: ['./censimento.component.css']
})
export class CensimentoComponent implements OnInit {

  formCensimento = this.formBuilder.group({
    nome: ['',[Validators.required,Validators.minLength(4),Validators.maxLength(8),Validators.pattern("^[a-zA-Z]*$")]],
    cognome: ['',[Validators.required,Validators.minLength(4),Validators.maxLength(10),Validators.pattern("^[a-zA-Z]*$")]],
    dataNascita: ['',[Validators.required]],
    citta: ['',[Validators.required,Validators.pattern("^[a-zA-Z ]*$")]]
  });

  constructor(private formBuilder: FormBuilder, private personaService: PersonaService, private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.route.queryParams.subscribe((params) => {
      if(params.edit){
        this.personaService.getById(params.edit).subscribe((data) => {
          this.inputNome.setValue(data.nome);
          this.inputCognome.setValue(data.cognome);
          this.inputDataNascita.setValue(new Date(data.dataNascita).toISOString().slice(0, 10));
          this.inputCitta.setValue(data.citta);
        })
      }
    });

  }

  onSave(){
    if(this.formCensimento.valid){

      const personaDTO = {
        "id": -1,
        "nome": this.inputNome.value,
        "cognome": this.inputCognome.value,
        "citta": this.inputCitta.value,
        "dataNascita": new Date(this.inputDataNascita.value)
      }

      if(this.route.snapshot.queryParams.edit){
        const id = this.route.snapshot.queryParams.edit;
        this.personaService.update(id,personaDTO).subscribe(() => {
          this.router.navigate(['/ricerca'])
        })
      }
      else {
        this.personaService.save(personaDTO).subscribe(() => {
          this.router.navigate(['/ricerca'])
        })
      }

    }

  }


  get inputNome() : AbstractControl{
    return this.formCensimento.get('nome')!;
  }

  get inputCognome() : AbstractControl{
    return this.formCensimento.get('cognome')!;
  }

  get inputDataNascita() : AbstractControl{
    return this.formCensimento.get('dataNascita')!;
  }

  get inputCitta() : AbstractControl{
    return this.formCensimento.get('citta')!;
  }

}
