describe('Variables', function(){

    nom = "Pierre";

    it('Variables - 1', function(){
        // _
        expect(nom).toBe('Thierry');
        expect(window.nom).toBe('Thierry');
    })

    age = 6;

    it('Variables - 2', function(){
        // _
        expect(age).toBe(4);
        expect(window.age).toBe(6);
    })

});