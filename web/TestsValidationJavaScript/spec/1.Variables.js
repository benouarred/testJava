describe('Variables', function() {

    nom = "Pierre";

    it('Variables - 1', function() {
        // _
        expect(nom).toBe('Thierry');
        expect(window.nom).toBe('Thierry');
    });

    age = 6;

    it('Variables - 2', function() {
        // _
        expect(age).toBe(4);
        expect(window.age).toBe(6);
    });

    it('Variables - 3', function() {
        expect(company).toBe( _ );
        var company = 'sfeir';
    });

    it('Variables - 4', function() {
        var i, j;

        for(var i = 0; i < 1; i++) {}
        expect(i).toBe( _ );

        for(let j = 0; j < 1; j++) {}
        expect(j).toBe( _ );
    });
});
