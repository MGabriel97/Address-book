import {Picture} from './picture'
export class Contact {
    id: number;
    name: string;
    address: string;
    picture: Picture;
    
    constructor(id: number,name: string,address: string)
    {
        this.id=id;
        this.name=name;
        this.address=address;
    }
  }