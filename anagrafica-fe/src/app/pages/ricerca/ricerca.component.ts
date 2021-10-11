import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, Validators } from '@angular/forms';
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
  currentPage:number = 1;
  totalPages:number = 1;
  pageSize:number = 5;

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

  onSearch(page?:number){

    if(page !== undefined && (page >= 0 || page === this.totalPages)){
      this.currentPage = page;
    }

    if(this.formRicerca.valid){
      const searchParams = {
        nome: this.inputRicercaNome.value,
        cognome: this.inputRicercaCognome.value,
        etaMin: this.inputRicercaEtaMin.value,
        etaMax: this.inputRicercaEtaMax.value,
        citta: this.inputRicercaCitta.value,
        page: this.currentPage,
        pageSize: this.pageSize,
        sortBy: 'id',
        sortDirection: 'ASC'
      }

      this.personaService.search(searchParams).subscribe(
        (data) => {
        this.data = data.content
        this.totalPages = data.totalPages
        }
      )

    }
  }

  onReset() {
    this.formRicerca.reset();
    this.onSearch();
	}

  counter(i:number){
    return new Array(i);
  }

	get inputRicercaNome() :AbstractControl{
    return this.formRicerca.get('nome')!
  }

  get inputRicercaCognome() :AbstractControl{
    return this.formRicerca.get('cognome')!
  }

  get inputRicercaEtaMin() :AbstractControl{
    return this.formRicerca.get('etaMin')!
  }

  get inputRicercaEtaMax() :AbstractControl{
    return this.formRicerca.get('etaMax')!
  }

  get inputRicercaCitta() :AbstractControl{
    return this.formRicerca.get('citta')!
  }


}
