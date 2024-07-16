describe("Codurance.com", () => {
    it("user should be able to navigate to Technology and Software page", () => {
        cy.visit("https://www.codurance.com/");

        const confirmCookies = cy.get("#hs-eu-confirmation-button");
        confirmCookies.click();

        const discoverOurServices = cy.get("#cta_button_3042464_f1c409b0-a5be-48c0-8ac2-323f13214d56 > span");
        discoverOurServices.click();

        const industriesButton = cy.get(".feature-section > .custom-btn > .button-primary");
        industriesButton.click();

        const technologyCard = cy.get(":nth-child(9) > a > .hs-image__grid__item__overlay__content");
        technologyCard.click();

        cy.get("h1").should("contain.text", "Agility and excellence");
    });
});
