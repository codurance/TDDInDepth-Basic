import {User} from "./User.ts";

export class OrderProcessor {
    private orderCount: number;

    constructor(orderCount: number) {
        this.orderCount = orderCount;
    }

    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    public processOrder(_user: User): number {
        this.orderCount++;

        const orderId = this.orderCount;

        console.log("Processing order " + orderId);

        return orderId;
    }
}