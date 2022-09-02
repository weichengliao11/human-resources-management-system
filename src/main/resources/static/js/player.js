
$('document').ready(function(){

    $('table #editButton').on('click', function(event){
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(player, status){
            $('#playerIdEdit').val(player.playerId);
            $('#playerNameEdit').val(player.playerName);
            $('#playerNationEdit').val(player.playerNation);
            $('#playerNationNumberEdit').val(player.playerNationNumber);
            $('#playerClubEdit').val(player.playerClub);
            $('#playerClubNumberEdit').val(player.playerClubNumber);
            $('#playerPositionEdit').val(player.playerPosition);
            $('#imageUrlEdit').val(player.imageUrl);

        });

        $('#editModal').modal();
    });

    $('table #deleteButton').on('click', function(event){
        event.preventDefault();

        var href = $(this).attr('href');

        $('#confirmDeleteButton').attr('href', href);

        $('#deleteModal').modal();
    });

    $('.table #photoButton').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#photoModal #playerPhoto').attr('src', href);
        $('#photoModal').modal();
    });


});