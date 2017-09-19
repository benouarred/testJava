describe('JavaScript: The Other Parts', function() {

    it("Bonus 1: scope extra", function() {
        //_ (Math)
        {
            expect( cos(PI) ).toBe( -1 );
        }
    });

    it("Bonus 2: syndrome des points-virgules", function() {
        function f() {
            return
                "done";
        }
        expect( f() ).toBe( _ );
    });

    it("Bonus 3: décalage horaire", function() {
        var aujourdhui = new Date(2017, _, 22);
        expect(aujourdhui.toLocaleDateString()).toBe("22/09/2017");
    });

    it("Bonus 4: l'épouvantail de Crockford", function() {
        with({Math: {cos: x => x + "zza", PI: "pi"}})
        {
            with(self) {
                expect( cos(PI) ).toBe( _ );
            }
        }
    });

    it("Bonus 5: je suis falsy… qui suis-je ?", function(){
        var thing = _ ;
        expect(thing).toBeFalsy();
        expect(+thing).toBe(0);
        expect(typeof thing).toBe( "object" );
    });

    it("Bonus 6: je suis truthy… qui suis-je ?", function(){
        var thing = _ ;
        expect(thing).toBeTruthy();
        expect(+thing).toBe(0);
        expect(typeof thing).toBe( "object" );
    });
});
