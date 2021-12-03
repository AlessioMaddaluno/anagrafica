import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, AbstractControl } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { PageEvent } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { PersonaService } from 'src/app/core/services/persona.service';
import { Persona } from 'src/app/shared/models/persona.model';
import { ModalConfermaComponent } from '../modal-conferma/modal-conferma.component';

@Component({
  selector: 'app-ricerca',
  templateUrl: './ricerca.component.html',
  styleUrls: ['./ricerca.component.css']
})
export class RicercaComponent implements OnInit {

  data: Persona[] = []
  currentPage:number = 0;
  totalPages:number = 1;
  pageSize:number = 10;
  totalElements:number = 0;

  displayedColumns = [
    'nome',
    'cognome',
    'dataNascita',
    'citta',
    'edit',
    'delete'
  ]

  formRicerca = this.formBuilder.group({
    nome: ['', [Validators.pattern("^[a-zA-Z]*$")]],
    cognome: ['', [Validators.pattern("^[a-zA-Z]*$")]],
    dataNascitaMin: [''],
    dataNascitaMax: [''],
    citta: ['', [Validators.pattern("^[a-zA-Z ]*$")]]
  });

  constructor(
    private personaService:PersonaService,
    private formBuilder:FormBuilder,
    private router:Router,
    public dialog: MatDialog) { }

  ngOnInit(): void {
    this.onSearch();
  }

  onEdit(id:number){
    this.router.navigate(['/censimento'], { queryParams: { edit: id } });
  }

  onSearch(page?:number){

    if(page !== undefined && (page >= 0 || page === this.totalPages)){
      this.currentPage = page;
    }

    if(this.formRicerca.valid){

      let dataNascitaMin = (this.inputDataNascitaMin.value) ? new Date(this.inputDataNascitaMin.value) : null;
      let dataNascitaMax = (this.inputDataNascitaMax.value) ? new Date(this.inputDataNascitaMax.value) : null;

      const searchParams = {
        nome: this.inputRicercaNome.value,
        cognome: this.inputRicercaCognome.value,
        citta: this.inputRicercaCitta.value,
        dataNascitaMin: dataNascitaMin,
        dataNascitaMax: dataNascitaMax,
        page: this.currentPage,
        pageSize: this.pageSize,
        sortBy: 'id',
        sortDirection: 'ASC'
      }

      this.personaService.search(searchParams).subscribe(
        (data) => {
          this.totalElements = data.totalElements
          this.data = data.content
          this.totalPages = data.totalPages
        }
      )

    }
  }

  onReset() {
    this.formRicerca.reset();
    this.onSearch();
    this.currentPage = 0;
	}

  onPageChange(event : PageEvent){
    this.currentPage = event.pageIndex;
    this.pageSize = event.pageSize;
    this.onSearch();
  }

  counter(i:number){
    return new Array(i);
  }

  openDialogDelete(id:number): void {
    const confermaEliminazione:boolean = false;
    const dialogRef = this.dialog.open(ModalConfermaComponent, {
      width: '350px'
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result){
        this.personaService.deleteById(id).subscribe(() => {
          this.onSearch()
        })
      }
    })
  }

	get inputRicercaNome() :AbstractControl{
    return this.formRicerca.get('nome')!
  }

  get inputRicercaCognome() :AbstractControl{
    return this.formRicerca.get('cognome')!
  }

  get inputRicercaCitta() :AbstractControl{
    return this.formRicerca.get('citta')!
  }

  get inputDataNascitaMax(): AbstractControl{
    return this.formRicerca.get('dataNascitaMax')!;
  }

  get inputDataNascitaMin(): AbstractControl{
    return this.formRicerca.get('dataNascitaMin')!;
  }

}
