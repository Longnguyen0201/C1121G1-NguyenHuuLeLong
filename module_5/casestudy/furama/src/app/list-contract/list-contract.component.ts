import { Component, OnInit } from '@angular/core';
import {Contract} from '../../models/contract';
import {ContractService} from '../../services/contract-service';

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {
  contracts: Contract[];
  constructor(private contractService: ContractService) {
    // @ts-ignore
    this.contracts = this.contractService.getContractList();
  }

  ngOnInit(): void {
  }

}
