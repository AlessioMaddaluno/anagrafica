import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Persona } from 'src/app/models/persona.model';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-ricerca',
  templateUrl: './ricerca.component.html',
  styleUrls: ['./ricerca.component.css']
})
export class RicercaComponent implements OnInit {

  data: Persona[] = []

  formRicerca = this.formBuilder.group({
    nome: ['', [Validators.pattern("^[a-zA-Z]*$")]],
    cognome: ['', [Validators.pattern("^[a-zA-Z]*$")]],
    etaMin: [''],
    etaMax: [''],
    citta: ['', [Validators.pattern("^[a-zA-Z ]*$")]]
  });

  constructor(private personaService:PersonaService,private formBuilder:FormBuilder, private router:Router) { }

  ngOnInit(): void {
    this.onSearch();
  }

  onDelete(id:number){
    this.personaService.deleteById(id).subscribe(() => {
      this.onSearch()
    })
  }

  onEdit(id:number){
    this.router.navigate(['/censimento'], { queryParams: { edit: id } });
  }

  onSearch(){
    if(this.formRicerca.valid){
      const dto = {
        nome: this.formRicerca.controls.nome.value,
        cognome: this.formRicerca.controls.cognome.value,
        etaMin: this.formRicerca.controls.etaMin.value,
        etaMax: this.formRicerca.controls.etaMax.value,
        citta: this.formRicerca.controls.citta.value,
        page: 0,
        pageSize: 999999,
        sortBy: 'id',
        sortDirection: 'ASC'
      }

      this.personaService.search(dto).subscribe(
        (data) => { this.data = data.content}
      )

    }
  }

  onReset() {
    this.formRicerca.reset();
    this.onSearch();
  }

}
