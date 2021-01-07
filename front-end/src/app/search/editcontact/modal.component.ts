import { ModalEditComponentConfirm } from './modalconfirm.component';
import {Component, Type,Input } from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient, HttpEventType,HttpErrorResponse } from '@angular/common/http';
import { NgForm }   from '@angular/forms';
import {  throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import {Contact} from '../../shared/contact'

const MODALS: {[name: string]: Type<any>} = {
  focusFirst: ModalEditComponentConfirm
};
@Component({
  selector: 'app-modal-edit',
  templateUrl: './modal.component.html',
})
export class ModalEditComponent  {

  @Input()
  contact: Contact ;

constructor(private _modalService: NgbModal) {}

open(name: string) {
  const modalRef = this._modalService.open(MODALS[name]);
  modalRef.componentInstance.contact=this.contact;
}
}

