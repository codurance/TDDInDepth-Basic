export interface PaymentGateway {
    charge(amount: number): boolean;
}