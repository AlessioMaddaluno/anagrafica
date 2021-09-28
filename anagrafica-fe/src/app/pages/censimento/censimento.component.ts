import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-censimento',
  templateUrl: './censimento.component.html',
  styleUrls: ['./censimento.component.css']
})
export class CensimentoComponent implements OnInit {


  formCensimento = this.formBuilder.group({
    nome: ['',[Validators.required,Validators.minLength(4),Validators.maxLength(8),Validators.pattern("^[a-zA-Z]*$")]],
    cognome: ['',[Validators.required,Validators.minLength(4),Validators.maxLength(10),Validators.pattern("^[a-zA-Z]*$")]],
    eta: ['',[Validators.required,Validators.min(18),Validators.max(70)]],
    citta: ['',[Validators.required,Validators.pattern("^[a-zA-Z ]*$")]]
  });

  constructor(private formBuilder: FormBuilder, private personaService: PersonaService, private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.route.queryParams.subscribe((params) => {

      if(params.edit){
        this.personaService.getById(params.edit).subscribe((data) => {
          this.formCensimento.controls.nome.setValue(data.nome);
          this.formCensimento.controls.cognome.setValue(data.cognome);
          this.formCensimento.controls.eta.setValue(data.eta);
          this.formCensimento.controls.citta.setValue(data.citta);
        })
      }

    });
  }

  onSave(){
    if(this.formCensimento.valid){

      const personaDTO = {
        "id": -1,
        "nome": this.formCensimento.controls.nome.value,
        "cognome": this.formCensimento.controls.cognome.value,
        "eta": this.formCensimento.controls.eta.value,
        "citta": this.formCensimento.controls.citta.value
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


}
