export class PaymentChargeFailed extends Error {

    public static with(amount: number) {
        return new PaymentChargeFailed("Payment charge failed for amount of: " + amount)
    }
}