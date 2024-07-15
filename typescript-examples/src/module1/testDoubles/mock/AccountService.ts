import {Logger} from "./Logger.ts";

export class AccountService {
    private readonly logger: Logger

    constructor(logger: Logger) {
        this.logger = logger;
    }

    public addDeposit(amount: number): void {
        // Here goes the "add deposit" logic

        this.logger.log("Deposit added: " + amount);
    }
}